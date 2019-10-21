package com.example.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;
public class MyGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //        初始化获取request请求
        ServerHttpRequest request = exchange.getRequest();

        String newPath = request.getURI().getRawPath();
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        String secret = httpHeaders.getFirst("key");
        ServerHttpResponse response = exchange.getResponse();
        //指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
        if ("".equals(secret)) {
            //当请求不携带或secret者secret为空时，直接设置请求状态码为401，返回
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            DataBuffer buffer = response.bufferFactory().wrap("失败"
                    .getBytes(StandardCharsets.UTF_8));
            return response.writeWith(Mono.just(buffer));
        }
//        使用查询到的服务IP构建URI，进行路由的转发
        URI uri = UriComponentsBuilder.fromHttpUrl("http://www.baidu.com").build().toUri();
        ServerHttpRequest httpRequest = request.mutate().uri(uri).build();
        Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
        Route newRoute = Route.async()
                .asyncPredicate(route.getPredicate())
                .filters(route.getFilters())
                .id(route.getId())
                .order(route.getOrder())
                .uri(uri).build();
        exchange.getAttributes().put(GATEWAY_ROUTE_ATTR,newRoute);

        return chain.filter(exchange.mutate().request(httpRequest).build());
    }


    @Override
    public int getOrder() {
        return -100;
    }
}
