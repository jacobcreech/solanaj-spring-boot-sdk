package org.solanaj;

import lombok.Getter;
import lombok.Setter;
import org.p2p.solanaj.rpc.WeightedCluster;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.p2p.solanaj.rpc.Cluster;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("solanaj")
public class RpcClientProperties {

    public String endpoint = Cluster.MAINNET.getEndpoint();
    public WeightedCluster cluster;

}
