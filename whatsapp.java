import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class whatsapp {
      public static void main(String[] args) {
        // ✅ Your WhatsApp group invite link
        String message = "";  // <-- put your group link here

        // ✅ The phone number (with country code, no +)
        String number = "918555088711";  // 91 + phone number

        // ✅ Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.get("https://web.whatsapp.com");

        // Pause to scan QR
        System.out.println("📷 Please scan the QR code in the opened Chrome window...");
        try {
            Thread.sleep(20000);  // wait 20 seconds for QR scan
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("➡️ Sending to " + number + "...");
            String url = "https://web.whatsapp.com/send?phone=" + number + "&text=" + message;
            driver.get(url);

            // Wait for chat box to load
            Thread.sleep(12000);  // adjust if internet is slow

            // Find input box
            WebElement messageBox = driver.findElement(By.xpath("//div[@contenteditable='true'][@data-tab='10']"));
            messageBox.sendKeys(Keys.ENTER);

            System.out.println("✅ Sent to " + number);
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("❌ Failed for " + number + ": " + e.getMessage());
        }

        driver.quit();
    }
}
