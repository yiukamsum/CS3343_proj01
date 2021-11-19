package obj;

public abstract class DbAction {
    private Database db;

    public DbAction() {
        db = Database.connectDB(this);
    }

    protected Database getDatabase() {
        return this.db;
    }
}
