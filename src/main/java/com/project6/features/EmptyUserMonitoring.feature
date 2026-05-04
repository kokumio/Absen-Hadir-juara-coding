Feature: User Monitoring
  Sebagai admin
  Saya ingin menambahkan data user baru melalui halaman user monitoring
  Untuk mengelola pengguna sistem

  Background:
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button

  Scenario: Gagal menambahkan data baru di user monitoring 
    And user click menu management 
    And user click user monitoring menu
    And user click tambah menu monitoring
    And user click batal user monitoring
    Then user kembali ke halaman user monitoring