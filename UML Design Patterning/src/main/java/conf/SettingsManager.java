package conf;


public class SettingsManager {

    private static SettingsManager instance;
	private String theme;
    private int fontSize;
    
    public static SettingsManager getInstance(){
        if(instance == null){
            instance = new SettingsManager();
        }
        return instance;
    }


    private SettingsManager() {
        theme = "Default";
        fontSize = 12;
    }
    
    // Getters and setters for settings
    public String getTheme() {
        return theme;
    }
    
    public void setTheme(String theme) {
        this.theme = theme;
        // Additional logic to apply theme changes
        System.out.println("Theme set to: " + theme);
    }
    
    public int getFontSize() {
        return fontSize;
    }
    
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
        System.out.println("Font size set to: " + fontSize);
    }
    
}

