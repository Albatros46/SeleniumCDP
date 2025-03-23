# SeleniumFeaturesLatest

## 📌 Proje Açıklaması
Bu proje, **Selenium WebDriver** ve **Chrome DevTools Protocol (CDP)** kullanarak farklı test senaryolarını içeren bir **Otomasyon Test** çalışmasıdır. Proje içinde ağ hızını simüle etme, ağ isteklerini engelleme, mobil emülasyonu, sahte yanıtları işleme ve konum belirleme gibi farklı test senaryoları bulunmaktadır.

## 🚀 Kullanılan Teknolojiler
- **Java 23**
- **Selenium WebDriver**
- **Chrome DevTools Protocol (CDP)**
- **Maven**

## 🔧 Gereksinimler
Projeyi çalıştırmadan önce aşağıdaki araçların yüklü olması gerekmektedir:

- **Java 23 ve üzeri**
- **Maven** (Dependency yönetimi için)
- **Google Chrome** (Web testleri için)
- **ChromeDriver** (Selenium'un Chrome ile çalışması için uyumlu sürüm olmalı)
- **Git** (Projeyi GitHub'dan klonlamak için)

## 📥 Kurulum
1. **Projeyi klonla:**
   ```sh
   git clone https://github.com/Albatros46/SeleniumFeaturesLatest.git
   cd SeleniumFeaturesLatest
   ```
2. **Maven bağımlılıklarını yükle:**
   ```sh
   mvn clean install
   ```
3. **Testleri çalıştır:**
   ```sh
   mvn test
   ```

## 📂 Proje Klasör Yapısı
```
SeleniumFeaturesLatest/
│── src/
│   ├── testig/
│   │   ├── BlockNetworkRequests.java
│   │   ├── CdpCommandsTest.java
│   │   ├── MobileEmulatorTest.java
│   │   ├── NetworkFailedRequest.java
│   │   ├── NetworkLogActivity.java
│   │   ├── NetworkMocking.java
│   │   ├── NetworkSpeed.java
│   │   ├── SetGeoLocation.java
│── drivers/
│── target/
│── pom.xml
```

## 📜 Test Senaryoları
- **BlockNetworkRequests.java** → Belirli ağ isteklerini engelleyen test senaryosu.
- **CdpCommandsTest.java** → Chrome DevTools Protocol komutlarını test eden senaryo.
- **MobileEmulatorTest.java** → Mobil tarayıcı emülasyonu yaparak test çalıştıran senaryo.
- **NetworkFailedRequest.java** → Hatalı ağ isteklerini işleyerek hata durumlarını test eder.
- **NetworkLogActivity.java** → Ağ isteklerini kaydederek analiz yapan test senaryosu.
- **NetworkMocking.java** → Sahte ağ yanıtları oluşturarak uygulamanın nasıl tepki verdiğini test eder.
- **NetworkSpeed.java** → Ağ hızını simüle ederek yavaş bağlantılarda test çalıştırır.
- **SetGeoLocation.java** → Farklı coğrafi konumları simüle ederek testleri çalıştırır.

## 📌 Nasıl Katkıda Bulunabilirsiniz?
1. **Projeyi forklayın** 🚀
2. Yeni bir özellik eklemek için **branch** oluşturun 🌿
3. Değişikliklerinizi yapıp **commit** atın 💾
4. **Pull request** gönderin 📤

## 📜 Lisans


