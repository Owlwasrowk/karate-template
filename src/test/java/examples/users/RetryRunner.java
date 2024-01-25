package examples.users;

import com.intuit.karate.junit5.Karate;

class RetryRunner {
    
    @Karate.Test
    Karate testUsers() {
        return Karate.run("users").relativeTo(getClass());
    }    

}
