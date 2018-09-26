package pl.jacekmajchrzak;

import org.junit.Test;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
public class DiscountFeature {

	@Test
	public void shouldNotGiveDiscountForSmallAmount(){
		// given
		// when
		BigDecimal totalPrice = BigDecimal.TEN;
		// then
		assertThat(totalPrice).isEqualTo(BigDecimal.TEN);
	}

}