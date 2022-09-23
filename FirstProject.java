package ru.yandexMarket;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FirstProject {

    @Test
    public void ThisIsWay() throws Exception {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://ya.ru/");
        driver.get("https://market.yandex.ru/");
        driver.findElement(By.id("catalogPopupButton")).click();
        driver.get("https://market.yandex.ru/catalog--elektronika/54440");
        //Упростить путь (Xpath) Смартфоны
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div[1]/a/div/div")).click();
        //Упростить путь (Xpath) Смартфоны 2-ой переход
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/a")).click();
        //Расширеный поиск
        driver.get("https://market.yandex.ru/catalog--smartfony/26893750/filters?glfilter=21194330%3A38083630%2C34066443&hid=91491&onstock=0&local-offers-first=0");
        //Установка значений цены
        driver.findElement(By.xpath("/html/body/div[4]/section/div[2]/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]/input")).sendKeys("20000");
        //Прокрутка страницы на 400pixel по вертикали вниз
        Thread.sleep(2000);
        //Прокрутка страницы на 800pixel по вертикали вниз
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        Thread.sleep(2000);
        //Выбор диагонали экрана
        driver.findElement(By.xpath("/html/body/div[4]/section/div[2]/div/div/div[2]/div[1]/div[11]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/section/div[2]/div/div/div[2]/div[1]/div[11]/div/div/div/div[1]/input")).sendKeys("3");
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        //Выбираю 5 "популярных" производителей
        driver.findElement(By.xpath("//*[@id=\"10380976\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"153061\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"16713696\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"10556303\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"7701962\"]/div")).click();
        Thread.sleep(2000);
        //Показать результат
        driver.findElement(By.xpath("/html/body/div[4]/section/div[2]/div/div/div[3]/div/div/a[2]")).click();
        Thread.sleep(5000);

        //Создаем список всех найденных товаров
        //List<WebElement> search_results = driver.findElements(By.xpath("//*[@id=\"page-0jgpspwlmca8\"]/div/div/div/div/div"));

        //Убеждаемся что товара 10
        //assertThat(10, equalTo(search_results.size()));

        //Запомнить первый элемент
        //WebElement tablet = search_results.get(1);

        //Изменить сортировку
        driver.findElement(By.xpath("//*[@id=\"serpTop\"]/div/div/div[1]/div/div/div/button[3]")).click();

        //Найти запомненный объект
        //WebElement tablet = search_results.get(1);
        //String find_tablet = tablet.findElement(By.xpath(".//descendant::a")).getText();
        //WebElement search = driver.findElement(By.xpath("//input[@aria-labelledby='header-search header-search-label']"));
        //search.sendKeys(find_tablet);
        //search.submit();
        //String concrete_tablet_title =  driver.findElement(By.xpath("//h1[contains(@class,'title title_size_22')]")).getText();
        //find_tablet.equals(concrete_tablet_title);

        //Вывести цифровое значение его оценки.???

        //Закрыть браузер
        driver.close();
    }
}
