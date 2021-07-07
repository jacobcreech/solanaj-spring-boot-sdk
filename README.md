# solanaj-spring-boot-sdk
Auto Injection of SolanaJ for Spring-Boot

### Requirements

- Java 8+
- Spring-boot 2.1+

### Dependencies

- solanaj
- spring-boot-starter
- spring-boot-configuration-processor

### How to Use

Anywhere in your spring-boot project you can inject the SolanaJ API client by doing one of the following:

```java
@Autowired
private RpcClient client;
```

```java
private final RpcClient client;

public Constructor(RpcClient client) {
    this.client = client;
}
```

This will auto inject a client for you to interact with Solana's JSONRpc.

You can manually configure the JSONRpc endpoints with the following properties:

```yaml
solanaj:
  endpoint: https://api.mainnet-beta.solana.com
  cluster:
    endpoints:
      - url: https://api.mainnet-beta.solana.com
        weight: 50
      - url: https://solana-api.projectserum.com
        weight: 50
```

`solanaj.endpoint` will default to `https://api.mainnet-beta.solana.com` if not set.

The `solanaj.cluster.endpoints` allows you to override the main endpoint with a [`WeightedEndpoint`](https://github.com/skynetcapital/solanaj/blob/main/src/main/java/org/p2p/solanaj/rpc/types/WeightedEndpoint.java). Using weightedEndpoints, you can configure how often you want an endpoint to be used in the cluster.

In the example above, `https://api.mainnet-beta.solana.com` is used 50% of the time, and `https://solana-api.projectserum.com` the other 50%.

### License

solanaj-spring-boot-sdk is under the MIT license. See [LICENSE.md](https://github.com/cryptogosu/solanaj-spring-boot-sdk/blob/main/LICENSE) for more information.
