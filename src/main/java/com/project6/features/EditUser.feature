Feature: EditUser

  Scenario: Failed edit user
    # Langkah navigasi harus tetap ada jika @BeforeAll hanya sampai login dashboard
    When user click menu management and user menu
    And user click titik tiga menu
    And user click edit menu
    Then user mengosongkan field NIK
    And user click button save