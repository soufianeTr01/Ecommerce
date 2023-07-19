package org.sid.Ecommerce.config;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FlickrConfig {
    @Value("${flickr.apiKey}")
    private String apiKey;
    @Value("${flickr.apiSecret}")   
    private String  apiSecret;
    @Value("${flickr.appKey}")
    private String appKey;

    @Value("${flickr.appSecret}")
    private String appSecret;

    //Flickr est un service qui permet d'enregistre les image en l'api
   // @Bean
 /*   public Flickr getFlickr() throws IOException, ExecutionException, InterruptedException, FlickrException {
        Flickr flickr=new Flickr(apiKey,apiSecret,new REST());
        // creer lobjet avec la permisssion  que je veux
        OAuth10aService  service=new ServiceBuilder(apiKey)
                .apiSecret(apiSecret)
                .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE));
// utiliser scanner pour entrez le code que je recus
        final Scanner scanner=new Scanner(System.in);
//recuperer le request token
        final OAuth1RequestToken requestToken=service.getRequestToken();
        String authUrl =service.getAuthorizationUrl(requestToken);

        System.out.println(authUrl);
        System.out.println("Paste it here >>>");
        final String authVerifier= scanner.nextLine();

         OAuth1AccessToken accessToken=service.getAccessToken(requestToken,authVerifier);

        System.out.println(accessToken.getToken());
        System.out.println(accessToken.getTokenSecret());
// verifier ce tocken est ce qui la valide
        Auth  auth =flickr.getAuthInterface().checkToken(accessToken);
        System.out.println("------------------------------------");
        System.out.println(auth.getToken());
        System.out.println(auth.getTokenSecret());
        return  flickr ;
    }*/
   @Bean
   public Flickr getFlickr2() {
       Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
       Auth auth = new Auth();
       auth.setPermission(Permission.READ);
       auth.setToken(appKey);
       auth.setTokenSecret(appSecret);
       RequestContext requestContext = RequestContext.getRequestContext();
       requestContext.setAuth(auth);
       flickr.setAuth(auth);
       return flickr;
   }

}
