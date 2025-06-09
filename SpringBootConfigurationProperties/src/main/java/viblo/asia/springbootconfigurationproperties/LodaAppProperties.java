package viblo.asia.springbootconfigurationproperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component // Là 1 spring bean
//@PropertySource("classpath:loda.yml") // Đánh dấu để lấy config từ trong file loda.yml
@ConfigurationProperties(prefix = "loda") // Chỉ lấy các config có tiền tố là "loda"
public class LodaAppProperties {

    private String email;
    private String googleAnalyticsId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoogleAnalyticsId() {
        return googleAnalyticsId;
    }

    public void setGoogleAnalyticsId(String googleAnalyticsId) {
        this.googleAnalyticsId = googleAnalyticsId;
    }


}
