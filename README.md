Teknolojik Yigin

Proje, Spring boot framework’u kullanilarak gelistirilmistir. Veritabani islemleri icin Spring Data JPA kullanilmistir. API tasarimi icin RESTful yaklasimi benimsenmistir.

Mimari Tasarim

Controller katmani, istemciden gelen http isteklerini isleyen siniflari içerir. Her bir controller sinifi, farkli API endpointlerine karsilik gelir.

Service katmani, is mantiginin bulunduğu katmandir. Bu katman, veritabani erişimi için repository katmanina cagri yapar.

Repository katmani, veritabani işlemlerini gerçekleştiren Sprin Data JPA repository arayuzleri içerir. Bu katman veritabani işlemlerini uygular.

Entity Ilişkileri

Customer ile Cart arasinda OneToOne ilişki vardir.

Customer ile Order arasinda bir OneToMany ilişkisi vardir.

Cart ile CartItem arasinda bir OneToMany ilişkisi vardir.

Order ile OrderItem arasinda bir OneToMany ilişkisi vardir.

Is mantigi

Musteriler urunleri sepete ekleyebilir, sepetten cikarabilir veya seper içeriğini güncelleyebilir. Her işlemde toplam fiyat tekrar hesaplanir.

Musteri sepetteki urunlerle bir sipariş oluşturabilir. Siparis olusturuldugunda her bir urunun fiyati siparişe kaydedilir. Ayrica sipariş verildikten sonra stok miktari güncellenir.

Sepette stokta olmayan urunler eklenemez. Ayrica sepet bos olduğunda sipariş oluşturulamaz.

Kullanici Iletisimi ve Istek Isleme

Projenin API’si Restful mimari ile yapilmistir. Su http metodlari kullanilmistir:

GET: verileri almak için kullanilir. Or: GET /api/customers/{customerId}/cart ile müşterinin sepeti alinabilir.

POST: Yeni veriler eklemek için kullanilir. Or: POST /api/products ile yeni urun eklenebilir.

PUT: Var olan veriyi güncellemek için kullanilir. Or: PUT /api/cart/{cartId} ile sepet güncellenebilir.

DELETE: Verileri silmek için kullanilir. Or: DELETE /api/cart/{cartId}/product/{productId} ile sepetten urun cikarilabilir.

Test ve Hata Yonetimi

Proje Postman ile test edilmiştir. API endpointlerine yapilan http isteklerinin ciktilari kontrol edilmiştir. 

![image](https://github.com/user-attachments/assets/93ae6051-d0f4-40a3-87f5-15a09133bdf1)
