package lesson19;


public class Controller {
    public static File put(Storage storage, File file) throws Exception {
        validate(storage, file);

        int index = 0;
        for (File files : storage.getFiles()) {
            if (files == null) {
                storage.getFiles()[index] = file;
                break;
            }
            index++;
        }
        return storage.getFiles()[index];

    }

    public static void delete(Storage storage, File file) throws Exception {
       boolean isExist=false;
       for(File files:storage.getFiles()){
           if(files!=null&&files.equals(file)){
               isExist=true;
               break;
           }
       }
       if(!isExist) throw new Exception("File doesn't exist in storage "+storage.getId()+" Can't be deleted");

       int index=0;
        for(File files:storage.getFiles()){
            if(files!=null&&files.equals(file)){
                storage.getFiles()[index]=null;
            }
            index++;
        }
    }

    public static File transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        for (File files:storageFrom.getFiles()){
            transferFile(storageFrom,storageTo,files.getId());
        }
        return null;
    }

    public static File transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{
        File file = findById1(storageFrom,id);
        put(storageTo,file);

        return null;
    }

    private static void validate(Storage storage, File file) throws Exception {
        checkFormat(storage, file.getFormat());
        findById(storage, file.getId());
        checkSize(storage, file.getSize());
        checkFreeSpace(storage);
    }

    private static void checkFreeSpace(Storage storage) throws Exception {
        for (File files : storage.getFiles()) {
            if (files == null) return;
        }
        throw new Exception("No free space in storage " + storage.getId());
    }
    private static void checkForFreeSpace(Storage storage, int placeNeeded) throws Exception{
        int count = 0;
        for (File file:storage.getFiles()){
            if (file==null) count++;
        }
        if (count<placeNeeded) throw new Exception("No free space in storage "+storage.getId());
    }

    private static void checkSize(Storage storage, long fileSize) throws Exception {
        long used = 0;
        for (File files : storage.getFiles()) {
            if (files != null) used += files.getSize();
        }
        if (used + fileSize > storage.getStorageSize())
            throw new Exception("No free space in storage " + storage.getId());
    }

    private static void checkFormat(Storage storage, String fileFormat) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(fileFormat)) return;
        }
        throw new Exception(fileFormat + " is not supported in storage " + storage.getId());
    }

    private static File findById(Storage storage, long id) throws Exception {
        for (File files : storage.getFiles()) {
            if (files != null && files.getId() == id)
                throw new Exception("File "+id+" already exists in storage " +storage.getId());
        }
        return null;
    }
    private static File findById1(Storage storage, long id) throws Exception{
        for (File files : storage.getFiles()) {
            if (files != null && files.getId() == id)
                return files;
        }
        throw new Exception("File "+id+" already exists in storage " +storage.getId());
    }


}
