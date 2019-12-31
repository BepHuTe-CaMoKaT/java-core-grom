package lesson19;

import java.util.Objects;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) throws Exception{
        this.id = id;
        if (name.length()>10) throw new Exception("File "+id+" can't be created. Name lenght must be <=10");
        this.name = name;
        this.format = format;
        this.size = size;
    }

    public File() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        if (id != file.id) return false;
        return Objects.equals(name, file.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
