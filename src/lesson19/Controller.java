package lesson19;


public class Controller {
    public static File put(Storage storage, File file) throws Exception {
        validate(storage, file);

        int index = 0;
        File[] allFiles = storage.getFiles();
        for (File files : allFiles) {
            if (files == null) {
                allFiles[index] = file;
                index++;
            }
        }
        return null;

    }

    public void delete(Storage storage, File file) throws Exception {
        findById(storage,file.getId());

        int index=0;
        File[] allFiles = storage.getFiles();
        for (File files : allFiles) {
            if (files.getId() == file.getId()) {
                allFiles[index] = null;
                break;
            }
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        File[] origins = storageFrom.getFiles();
        File[] destinations = storageTo.getFiles();
        if (origins != destinations && storageFrom.getFormatsSupported() != storageTo.getFormatsSupported()) {
            throw new Exception("Origins and destinations do not match!");
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
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
        throw new Exception("No free space in storage" + storage.getId());
    }
    private static void checkForFreeSpace(Storage storage, int placeNeeded) throws Exception{
        int count = 0;
        for (File file:storage.getFiles()){
            if (file==null) count++;
        }
        if (count<placeNeeded) throw new Exception("No free space in storage"+storage.getId());
    }

    private static void checkSize(Storage storage, long fileSize) throws Exception {
        long used = 0;
        for (File files : storage.getFiles()) {
            if (files != null) used += files.getSize();
        }
        if (used + fileSize > storage.getStorageSize())
            throw new Exception("No free space in storage" + storage.getId());
    }

    private static void checkFormat(Storage storage, String fileFormat) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(fileFormat)) return;
        }
        throw new Exception(fileFormat + "is not supported in storage" + storage.getId());
    }

    private static File findById(Storage storage, long id) throws Exception {
        for (File files : storage.getFiles()) {
            if (files != null && files.getId() == id)
                throw new Exception("File " + id + " already exist in storage " + storage.getId());
        }
        return null;
    }


}
