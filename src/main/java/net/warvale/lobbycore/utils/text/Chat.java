package net.warvale.lobbycore.utils.text;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

public class Chat {

    public static String BLACK = ChatColor.BLACK.toString();
    public static String DARK_BLUE = ChatColor.DARK_BLUE.toString();
    public static String DARK_GREEN = ChatColor.DARK_GREEN.toString();
    public static String DARK_AQUA = ChatColor.DARK_AQUA.toString();
    public static String DARK_RED = ChatColor.DARK_RED.toString();
    public static String GOLD = ChatColor.GOLD.toString();
    public static String GRAY = ChatColor.GRAY.toString();
    public static String DARK_GRAY = ChatColor.DARK_GRAY.toString();
    public static String BLUE = ChatColor.BLUE.toString();
    public static String GREEN = ChatColor.GREEN.toString();
    public static String AQUA = ChatColor.AQUA.toString();
    public static String RED = ChatColor.RED.toString();
    public static String LIGHT_PURPLE = ChatColor.LIGHT_PURPLE.toString();
    public static String YELLOW = ChatColor.YELLOW.toString();
    public static String WHITE = ChatColor.WHITE.toString();

    public static String MAGIC = ChatColor.MAGIC.toString();
    public static String BOLD = ChatColor.BOLD.toString();
    public static String STRIKETHROUGH = ChatColor.STRIKETHROUGH.toString();
    public static String UNDERLINE = ChatColor.UNDERLINE.toString();
    public static String ITALIC = ChatColor.ITALIC.toString();
    public static String RESET = ChatColor.RESET.toString();

    public static String LINE = "\n";

    public static String CENTER(String message) {
        return StringUtils.center(message, 52);
    }
}
