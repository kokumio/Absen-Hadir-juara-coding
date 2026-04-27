Feature: User

  Scenario: Export data user
    # Langkah login dihapus dari sini karena sudah ditangani oleh @BeforeAll di Java
    When user click menu management and user menu
    And user click button export
    Then user success download file export