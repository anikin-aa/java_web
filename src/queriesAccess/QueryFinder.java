package queriesAccess;


import com.sun.istack.internal.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueryFinder {
    private static Logger log = Logger.getLogger(QueryFinder.class.getName());
    static String HARDCODE = "C:\\lab_4_test\\queries\\";
    static String extension = ".sql";

    @Nullable
    public static String getQuery(String fileName) {
        log.log(Level.INFO, "Getting Query from file: " + fileName);
        if (fileName == null || fileName.isEmpty()) {
            log.log(Level.WARNING, "File name is Null!");
            return null;
        }
        String query = null;
        String path = HARDCODE + fileName + extension;
        File pathQueries = new File(path);
        if (pathQueries.exists()) {
            Scanner scan = null;
            try {
                scan = new Scanner(pathQueries);
            } catch (FileNotFoundException e) {
                log.log(Level.WARNING, "File not found!: " + e);
            }
            if (scan != null && scan.hasNext()) {
                query = scan.useDelimiter("\\Z").next();
            } else {
                throw new Error("Scanner cant read from file: " + pathQueries.getAbsolutePath());
            }
        } else {
            throw new Error("File not found!");
        }
        return query;
    }
}
