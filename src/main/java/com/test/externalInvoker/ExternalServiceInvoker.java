package   com.test.externalInvoker;

import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.config.SystemConfig;
import com.test.domain.ExternalResponse;

/**
 * 
 * @author alex
 *
 */
@Service
public class ExternalServiceInvoker {

    @Autowired
    private SystemConfig config;

    private RestTemplate restTemplate;

    public <T> T invoke(String path, Map<String, Object> pathVariables,
                        Map<String, Object> queryVaribles, Class<T> returnType) throws Exception {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(config.getExternalUrl())
                .path(path);
        if (queryVaribles != null) {
            for (Entry<String, Object> entry : queryVaribles.entrySet()) {
                builder.queryParam(entry.getKey(), entry.getValue());
            }
        }
        URI targetUrl = null;
        if (pathVariables != null) {
            targetUrl = builder.buildAndExpand(pathVariables).toUri();
        } else {
            targetUrl = builder.build().toUri();
        }
        ExternalResponse response = restTemplate.getForObject(targetUrl, ExternalResponse.class);
        if (response == null) {
            throw new Exception("Get empty response from remote service.");
        }
        if (response.getCode() == HttpStatus.OK.value()) {
            return returnType.cast(response.getResult());
        } else {
            throw new Exception(String.format("Request ErrorCode:%s,Request ErrorMsg:%s",
                    response.getCode(), response.getMsg()));
        }

    }

    @PostConstruct
    public void init() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        restTemplate = builder.build();
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 */
