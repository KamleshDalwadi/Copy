package com.kamlesh.bhavcopy.service.factory;

import com.kamlesh.bhavcopy.service.strategy.CountQueryStrategy;
import com.kamlesh.bhavcopy.service.strategy.GainQueryStrategy;
import com.kamlesh.bhavcopy.service.strategy.QueryStrategy;
import com.kamlesh.bhavcopy.service.strategy.SymbolQueryStrategy;

public enum QueryType {
    SYMBOL(new SymbolQueryStrategy()),
    COUNT(new CountQueryStrategy()),
    GAIN(new GainQueryStrategy());

    private final QueryStrategy strategy;

    QueryType(QueryStrategy strategy) {
        this.strategy = strategy;
    }

    public static QueryType fromString(String queryType) {
        try {
            return QueryType.valueOf(queryType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown query type: " + queryType);
        }
    }

    public QueryStrategy getStrategy() {
        return strategy;
    }
}
