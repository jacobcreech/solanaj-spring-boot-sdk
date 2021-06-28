package org.solanaj;

import org.p2p.solanaj.rpc.RpcClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcClientConfig {

    private final RpcClientProperties rpcClientProperties;

    public RpcClientConfig(RpcClientProperties rpcClientProperties) {
        this.rpcClientProperties = rpcClientProperties;
    }

    @Bean
    public RpcClient rpcClient() {
        if (this.rpcClientProperties.cluster != null) {
            return new RpcClient(this.rpcClientProperties.cluster);
        }
        return new RpcClient(this.rpcClientProperties.endpoint);
    }

}
