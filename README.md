# 投票網站 REST API 說明文件

本專案為一個簡易線上投票系統，支援使用者註冊、投票項目管理、投票紀錄查詢與統計功能。
## 💻 專案基本資訊


| 🧩 項目       | 📋 說明                     |
|--------------|-----------------------------|
| 🐬 資料庫     | MySQL                        |
| ⚙️ 後端框架   | Spring Boot 3.5.3            |
| ☕ 程式語言   | Java 17                      |
| 🌐 架構風格   | RESTful API                  |


## 🐬 DB 

MYSQL 使用DOCKER 容器建立  MYSQL SERVER。

再另建一個 Container 作為 MYSQL CLI 操作介面。

STEP1 . docker 建立mysql sever 
```
docker run --name mysql-test -e MYSQL_ROOT_PASSWORD=1234 -p 3306:3306 -d mysql:8.0
```
STEP2 . docker 建立 mysql client
```
docker run -it --rm mysql:8.0 mysql -h host.docker.internal -uroot -p1234
```
STEP3 . CREATE DB SCHEMA
```
CREATE DATABASE voting_db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```
## 🐬 預設TABLE、Stored Procedure、測試資料　
schema.sql、data.sql：於 Spring Boot 應用啟動時自動執行

procedures.sql：需手動執行（包含 Stored Procedure）

📁 檔案說明：
 | 檔案名稱             | 說明                  |
| ---------------- | ------------------- |
| `schema.sql`     | 建立資料表               |
| `data.sql`       | 匯入預設測試資料            |
| `procedures.sql` | 建立 Stored Procedure |



## ✅ 完成項目 (API)

### 後台編輯投票項目功能
1. 頁面顯示所有投票項目
```
 GET /voteItem/all
```
2. 頁面顯示所有投票項目
```
 POST /voteItem
```
3. 頁面顯示所有投票項目
```
 PATCH /voteItem/{id}
```
### 後台編輯投票項目功能
1. 頁面顯示所有可投票項目和其目前累積票數。
```
 GET /votes/summary
```
2. 使用者可針對投票項目進行投票(可多選) 。
```
 POST /voteRecord
```
 ### 🚀 [👉 點我看詳細 API 文件](RESTFUL_API.md)

## 🔐 注意事項

- 所有請求與回應皆為 **JSON 格式**（除首頁）。
- 請務必加上 Header：`Content-Type: application/json`
- 所有需驗證的 API 必須先登入驗證，請使用 Postman 的 **Authorization → Basic Auth**
- API **/registUser 無須登入驗證 ，可以註冊後使用新增的帳號/密碼。**

### 🧑‍💻 測試帳號
- 帳號：`Leo` 
- 密碼：`123`

### 📸 Postman 設定示意圖
![Postman Basic Auth 設定示意圖](/md_images/image.png)


