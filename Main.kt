fun main() {
    val lib = Perpustakaan("Perpustakaan Amikom", "Jl. Merdeka No. 1")
    lib.tambahStaff(Staff("Admin"))  // Tambah staff untuk login awal
    lib.showMenu()
}