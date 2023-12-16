package DTO;
import java.util.List;
public class Planets {
    private String count;
    private String next;
    private String previous;
    private List<PlanetsResults> results;
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String getNext() {
        return next;
    }
    public void setNext(String next) {
        this.next = next;
    }
    public String getPrevious() {
        return previous;
    }
    public void setPrevious(String previous) {
        this.previous = previous;
    }
    public List<PlanetsResults> getResults() {
        return results;
    }
    public void setResults(List<PlanetsResults> results) {
        this.results = results;
    }
}
