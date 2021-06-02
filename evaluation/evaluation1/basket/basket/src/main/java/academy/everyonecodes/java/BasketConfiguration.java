//package academy.everyonecodes.java;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class BasketConfiguration {
//
//    @Bean
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//    @Bean
//    UsersClient client() {
//        return new UsersClient(restTemplate());
//    }
//
//    @Bean
//    SummaryCalculator calculator() {
//        return new SummaryCalculator(client());
//    }
//
//    @Bean
//    Basket basket() {
//        return new Basket(calculator());
//    }
//}
