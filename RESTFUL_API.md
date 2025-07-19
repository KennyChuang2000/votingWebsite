# RESTFUL API 詳細說明 
## 📌 1. 首頁與使用者註冊

### GET `/`

- **說明**：回傳歡迎訊息。
- **參數**：無
- **回應範例**：
  ```
  welcome to the voting website!
  ```

---

### POST `/registUser`

- **說明**：註冊新使用者。
- **請求內容（JSON）**：
  ```json
  {
    "id": "UUID 字串（可選，自動產生）",
    "username": "帳號（必填，需唯一）",
    "password": "密碼（必填）",
    "displayName": "顯示名稱（可選）"
  }
  ```
- **回應**：
  - 成功：
    - 狀態碼：`200 OK`
    - 內容：`User registered successfully`
  - 失敗：
    - 狀態碼：`400 Bad Request`
    - 內容：`Error registering user: 錯誤訊息`

---

## 🗳️ 2. 投票項目管理 `/voteItem`

### POST `/voteItem`

- **說明**：建立新的投票項目。
- **請求內容（JSON）**：
  ```json
  {
    "title": "投票項目名稱（必填）"
  }
  ```
- **回應**：
  - 成功：
    - 狀態碼：`201 Created`
    - 內容：`新增成功`
  - 失敗：
    - 狀態碼：`400 Bad Request`
    - 內容：`投票項目標題不能為空` 或 `新增失敗: 錯誤訊息`

---

### PATCH `/voteItem/{id}`

- **說明**：更新既有投票項目的標題。
- **路徑參數**：
  - `id`：投票項目 ID（Long 型態）
- **請求內容（JSON）**：
  ```json
  {
    "title": "新的標題（必填）"
  }
  ```
- **回應**：
  - 成功：
    - 狀態碼：`200 OK`
    - 內容：`更新成功`
  - 失敗：
    - 狀態碼：`400 Bad Request`
    - 內容：`標題不能為空` 或 `更新失敗: 錯誤訊息`

---

### GET `/voteItem/all`

- **說明**：取得所有投票項目。
- **回應**：
  - 成功：
    - 狀態碼：`200 OK`
    - 內容：
      ```json
      [
        {
          "id": 1,
          "title": "PC"
        },
        {
          "id": 2,
          "title": "Mouse"
        }
      ]
      ```
  - 失敗：
    - 狀態碼：`500 Internal Server Error`
    - 內容：錯誤訊息

---

## ✅ 3. 投票紀錄 `/voteRecord`

### GET `/voteRecord`

- **說明**：取得目前使用者的投票紀錄。
- **回應**：
  - 成功：
    - 狀態碼：`200 OK`
    - 內容：
      ```json
      [
          {
              "id": 2,
              "user": {
                  "id": "7d3d1d1a-9f84-4f90-83c0-3eb953e4e9b6",
                  "username": "Sandy",
                  "roles": "ROLE_USER",
                  "displayName": "Sandy"
              },
              "voteItem": {
                  "id": 1,
                  "title": "PC"
              }
          },
          {
              "id": 3,
              "user": {
                  "id": "7d3d1d1a-9f84-4f90-83c0-3eb953e4e9b6",
                  "username": "Sandy",
                  "roles": "ROLE_USER",
                  "displayName": "Sandy"
              },
              "voteItem": {
                  "id": 2,
                  "title": "Mouse"
              }
          }
      ]
      ```
  - 失敗：
    - 狀態碼：`500 Internal Server Error`
    - 內容：錯誤訊息

---

### POST `/voteRecord`

- **說明**：投票&更新投票（可複選）。
- **請求內容（JSON）**：
  ```json
  {
    "voteItemIds": [1, 2, 3]
  }
  ```
- **回應**：
  - 成功：
    - 狀態碼：`200 OK`
    - 內容：`投票成功`
  - 失敗：
    - 狀態碼：`400 Bad Request`
    - 內容：`投票失敗: 錯誤訊息`

---

## 📊 4. 投票統計 `/votes`

### GET `/votes/summary`

- **說明**：取得所有投票項目的票數統計。
- **回應**：
  - 成功：
    - 狀態碼：`200 OK`
    - 內容：
      ```json
      [
          {
              "id": 1,
              "title": "PC",
              "voteCount": 3
          },
          {
              "id": 2,
              "title": "Mouse",
              "voteCount": 3
          }
      ]
      ```

---

## 🔐 注意事項

- 所有請求與回應皆為 JSON 格式（除首頁）。
- 記得加上 `Content-Type: application/json` 標頭。
- 所有需驗證的 API 需先登入，請使用postman Authorization-> Basic Auth 帳號:Leo 密碼:123
![alt text](/md_images/image.png)
