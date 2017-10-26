## Remote Observer Pattern 

### Cara kerja:

 * Observer membuka port http 8080 (default), menset username, password, dan list ip yang dapat mengakses (whitelist).
 * Observer implementasi interface 'Observer' method onUpdate.
 * Observable mendaftarkan Observer dengan mencatat Ip address, Port, Username, Password.
 * Ketika terjadi perubahan di Observable, Observable memberi notifikasi kesemua Observer dengan cara memanngil 'Observer fireChanged'.
 * Ketika 'Observer fireChanged' dipanggil Observable, maka otomatis Observer yang telah didaftarkan akan mengeksekusi 'Observer onUpdate' sesuai implementasi masing-masing.

### Teknologi yang digunakan:

 * Java
 * Maven
 * Spring Security
 * Hessian

### Cara penggunaan:
 
 * Install Oberver dan Observable di repo maven lokal
    ```bash
    1. cd Observer
    2. mvn install
    3. cd ..
    4. cd Observable
    5. mvn install
    ```
 * Tambahkan depedency di POM
    ```xml
        <!--Untuk Observable -->
        <dependency>
            <groupId>id.muhamadridwan</groupId>
            <artifactId>Observable</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        
        <!--Untuk Observer -->
        <dependency>
            <groupId>id.muhamadridwan</groupId>
            <artifactId>Observer</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    ```
 * Untuk Observable Buat Class yang mengextend Class 'Observable'. Instance Interface 'Observer' kemudian panggil method addObserver. Ketika ingin memberi notifikasi panggil method 'fireChanged'.
 * Untuk Observer Buat Class yang mengextend Class ClientConfig dan Class yang mengimplement Interface Observer.
 

Click here to English tutorial :)
