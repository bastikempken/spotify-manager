package de.spotifymanager.devewebapi.endpoint.to.nested;

import java.math.BigDecimal;

public class FollowersTO {

    private String href;

    private BigDecimal total;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
