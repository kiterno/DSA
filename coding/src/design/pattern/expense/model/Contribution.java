package design.pattern.expense.model;

import java.util.Map;

public class Contribution {
    private Map<String, Double> contributionMap;

    public Map<String, Double> getContributionMap() {
        return contributionMap;
    }

    public void setContributionMap(Map<String, Double> contributionMap) {
        this.contributionMap = contributionMap;
    }
}
