public interface Frontier {

    public void add(Location loc);

    public Location next();

    public int size();

}
