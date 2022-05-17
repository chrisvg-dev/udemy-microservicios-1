package springbootserviciogatewayserver.filters;

import org.slf4j.*;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class Filters implements GlobalFilter {
	private final Logger logger = LoggerFactory.getLogger( Filters.class );

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		this.logger.info("EJECUTANDO METODO PRE");
		return chain.filter(exchange).then( Mono.fromRunnable( () -> {
			logger.info("EJECUTANDO FILTRO POST");
			exchange.getResponse().getCookies().add("cookie", ResponseCookie.from("nombre", "CRISTHIAN-VILLEGAS").build());
			exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
		}));
	}

}
