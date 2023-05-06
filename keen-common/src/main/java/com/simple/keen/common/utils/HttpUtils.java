package com.simple.keen.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;
import org.springframework.util.FileCopyUtils;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/4
 */
@Slf4j
public class HttpUtils {

    private static final String UNKNOWN = "unknown";

    public static String requestBrowser() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        StringBuilder userAgent = new StringBuilder("[");
        userAgent.append(request.getHeader("User-Agent"));
        userAgent.append("]");
        int indexOfWindows = userAgent.indexOf("Windows NT");
        int indexOfIe = userAgent.indexOf("MSIE");
        int indexOfIe11 = userAgent.indexOf("rv:");
        int indexOfFirefox = userAgent.indexOf("Firefox");
        int indexOfSogou = userAgent.indexOf("MetaSr");
        int indexOfChrome = userAgent.indexOf("Chrome");
        int indexOfSafari = userAgent.indexOf("Safari");
        boolean isWindows = indexOfWindows > 0;
        boolean containIe = indexOfIe > 0 || (isWindows && (indexOfIe11 > 0));
        boolean containFirefox = indexOfFirefox > 0;
        boolean containSogou = indexOfSogou > 0;
        boolean containChrome = indexOfChrome > 0;
        boolean containSafari = indexOfSafari > 0;
        String browser = "";
        if (containSogou) {
            if (containIe) {
                browser = "搜狗" + userAgent.substring(indexOfIe, indexOfIe + "IE x.x".length());
            } else if (containChrome) {
                browser = "搜狗" + userAgent.substring(indexOfChrome,
                    indexOfChrome + "Chrome/xx".length());
            }
        } else if (containChrome) {
            browser = userAgent.substring(indexOfChrome, indexOfChrome + "Chrome/xx".length());
        } else if (containSafari) {
            int indexOfSafariVersion = userAgent.indexOf("Version");
            browser = "Safari "
                + userAgent.substring(indexOfSafariVersion,
                indexOfSafariVersion + "Version/x.x.x.x".length());
        } else if (containFirefox) {
            browser = userAgent.substring(indexOfFirefox, indexOfFirefox + "Firefox/xx".length());
        } else if (containIe) {
            if (indexOfIe11 > 0) {
                browser = "IE 11";
            } else {
                browser = userAgent.substring(indexOfIe, indexOfIe + "IE x.x".length());
            }
        }
        return StringUtils.replace(browser, "/", " ");
    }

    public static String requestSystem() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        StringBuilder userAgent = new StringBuilder("[");
        userAgent.append(request.getHeader("User-Agent"));
        userAgent.append("]");
        int indexOfMac = userAgent.indexOf("Mac OS X");
        int indexOfWindows = userAgent.indexOf("Windows NT");
        boolean isMac = indexOfMac > 0;
        boolean isWindows = indexOfWindows > 0;
        boolean isLinux = userAgent.indexOf("Linux") > 0;
        String os = "";
        if (isMac) {
            os = userAgent.substring(indexOfMac, indexOfMac + "MacOS X xxxxxxxx".length());
        } else if (isLinux) {
            os = "Linux";
        } else if (isWindows) {
            os = "Windows ";
            String version = userAgent.substring(indexOfWindows + "Windows NT".length(),
                indexOfWindows
                    + "Windows NTx.x".length());
            switch (version.trim()) {
                case "5.0":
                    os += "2000";
                    break;
                case "5.1":
                    os += "XP";
                    break;
                case "5.2":
                    os += "2003";
                    break;
                case "6.0":
                    os += "Vista";
                    break;
                case "6.1":
                    os += "7";
                    break;
                case "6.2":
                    os += "8";
                    break;
                case "6.3":
                    os += "8.1";
                    break;
                case "10":
                    os += "10";
                default:
                    break;
            }
        }
        return os;
    }

    public static String requestIp() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    public static String requestLocation(String ip) {
        DbSearcher searcher = null;
        try {
            String dbPath = HttpUtils.class.getResource("/ip2region/ip2region.db").getPath();
            File file = new File(dbPath);
            if (!file.exists()) {
                String tmpDir = System.getProperties().getProperty("java.io.tmpdir");
                dbPath = tmpDir + "ip.db";
                file = new File(dbPath);
                FileCopyUtils.copy(HttpUtils.class.getClassLoader()
                        .getResourceAsStream("classpath:ip2region/ip2region.db"),
                    new FileOutputStream(file));
            }
            int algorithm = DbSearcher.BTREE_ALGORITHM;
            DbConfig config = new DbConfig();
            searcher = new DbSearcher(config, dbPath);
            Method method = null;
            switch (algorithm) {
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
            }
            DataBlock dataBlock = null;
            if (!Util.isIpAddress(ip)) {
                log.error("Error: Invalid ip address");
            }
            dataBlock = (DataBlock) method.invoke(searcher, ip);
            return dataBlock.getRegion();
        } catch (Exception e) {
            log.error("获取IP地址失败，{}", e.getMessage());
        } finally {
            if (searcher != null) {
                try {
                    searcher.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
