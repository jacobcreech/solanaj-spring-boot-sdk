package org.solanaj;

import org.junit.Assert;
import org.junit.Test;
import org.p2p.solanaj.rpc.RpcClient;
import org.p2p.solanaj.rpc.WeightedCluster;
import org.p2p.solanaj.rpc.types.WeightedEndpoint;

import java.util.Collections;

import static org.p2p.solanaj.rpc.Cluster.MAINNET;

public class RpcClientConfigTest {

    @Test
    public void rpcClientCreationTest() {
        RpcClientProperties properties = new RpcClientProperties();
        RpcClientConfig rpcClientConfig = new RpcClientConfig(properties);

        Assert.assertEquals("RPCClient not created", RpcClient.class, rpcClientConfig.rpcClient().getClass());
        Assert.assertEquals("RPCClient incorrectly configured", MAINNET.getEndpoint(), rpcClientConfig.rpcClient().getEndpoint());
    }

    @Test
    public void rpcClientCreationWithClusterTest() {
        RpcClientProperties properties = new RpcClientProperties();
        WeightedCluster cluster = new WeightedCluster(Collections.singletonList(new WeightedEndpoint(MAINNET.getEndpoint(), 100)));
        properties.setCluster(cluster);
        RpcClientConfig clientConfig = new RpcClientConfig(properties);

        Assert.assertEquals("RPCClient weightedCluster incorrectly configured", MAINNET.getEndpoint(), clientConfig.rpcClient().getEndpoint());

    }
}
