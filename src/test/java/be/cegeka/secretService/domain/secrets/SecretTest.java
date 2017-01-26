package be.cegeka.secretService.domain.secrets;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;


public class SecretTest {

    private Secret secret;

    @Before
    public void setUp() throws Exception {
        secret = new Secret("SECRET!!!!", "HASH!!!!");
    }

    @Test
    public void getOwnerHash() throws Exception {
        Assertions.assertThat(secret.getOwnerHash()).isEqualTo("HASH!!!!");
    }

    @Test
    public void getSecret() throws Exception {
        Assertions.assertThat(secret.getSecret()).isEqualTo("SECRET!!!!");
    }
}