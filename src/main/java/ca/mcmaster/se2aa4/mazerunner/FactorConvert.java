package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactorConvert {

    private static final Logger logger = LogManager.getLogger();
    
    //constructor
    public FactorConvert() {
    }

    //converts from factorized to canon path
    public String toCanon(String path) {
        logger.trace("**** Converting to canon");
        StringBuffer canon = new StringBuffer();
        int num = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) != 'F' && path.charAt(i) != 'L' && path.charAt(i) != 'R') {
                //finds factorized number
                while (path.charAt(i) != 'F' && path.charAt(i) != 'L' && path.charAt(i) != 'R') {
                    num = num * 10 + (path.charAt(i) - '0');
                    i++;
                }
                int idx = 0;
                //prints extra needed instructions
                while(idx < num - 1) {
                    canon.append(path.charAt(i));
                    idx++;
                }
                num = 0;
            }
            canon.append(path.charAt(i));
        }
        System.out.println(canon.toString());
        return canon.toString();
    }

    //converts from canon to factorized path
    public String toFactor(String path) {
        logger.trace("**** Converting to factorized");
        StringBuffer factor = new StringBuffer();
        int count = 1;
        for (int i = 0; i < path.length() - 1; i++) {
            if (path.charAt(i) == path.charAt(i+1)) {
                count++;
            } else {
                factor.append(count);
                factor.append(path.charAt(i));
                count = 1;
            }
        }
        if (path.charAt(path.length() - 1) != path.charAt(path.length() - 2)) {
            factor.append(path.charAt(path.length() - 1));
        } else {
            factor.append(count);
            factor.append(path.charAt(path.length() - 1));
        }
        return factor.toString();
    }
}