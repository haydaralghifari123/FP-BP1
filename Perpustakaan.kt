open class Perpustakaan(val nama: String, val alamat: String) {

    var bukuList = mutableListOf<Buku>()
    val peminjamList = mutableListOf<Peminjam>()
    val staffList = mutableListOf<Staff>()
    private var loggedInStaff: Staff? = null

    fun tambahBuku(buku: Buku) {
        bukuList.add(buku)
        println("Buku '${buku.judul}' telah ditambahkan.")
    }

    fun tambahPeminjam(peminjam: Peminjam) {
        peminjamList.add(peminjam)
        println("Peminjam '${peminjam.nama}' telah ditambahkan.")
    }

    fun tambahStaff(staff: Staff) {
        staffList.add(staff)
        println("Staff '${staff.nama}' telah ditambahkan.")
    }

    fun loginStaff() {
    println("----- Login Staff -----")
    var staff: Staff?
    do {
        print("Masukkan Nama Staff: ")
        val nama = readLine()!!.toString()
        staff = staffList.find { it.nama == nama }
        if (staff != null) {
            loggedInStaff = staff
            println("Staff '${staff.nama}' berhasil login.")
        } else {
            println("Staff dengan nama '$nama' tidak ditemukan. Silakan coba lagi.")
        }
    } while (staff == null)
}

    fun logoutStaff() {
        loggedInStaff = null
        println("Staff berhasil logout.")
    }

    fun showMenu() {
        if (loggedInStaff == null) {
            loginStaff()
        }

        var ulang: String
        do {
            println("\n\nSELAMAT DATANG DI APLIKASI PERPUSTAKAAN")
            println("1. Tambah Buku")
            println("2. Tambah Peminjam")
            println("3. Meminjam Buku")
            println("4. Mengembalikan Buku")
            println("5. Tampilkan Data Peminjam")
            println("6. Logout")
            println("7. Keluar")
            print("Pilih Menu: ")
            when (readLine()!!.toInt()) {
                1 -> {
                    val buku = Buku.inputBuku()
                    tambahBuku(buku)
                }
                2 -> {
                    val peminjam = Peminjam.inputPeminjam()
                    tambahPeminjam(peminjam)
                }
                3 -> {
                    if (peminjamList.isNotEmpty() && bukuList.isNotEmpty()) {
                        print("Masukkan NIM Peminjam: ")
                        val nim = readLine()!!
                        val peminjam = peminjamList.find { it.nim == nim }
                        if (peminjam != null) {
                            println("Daftar Buku Tersedia:")
                            bukuList.forEachIndexed { index, buku -> println("${index + 1}. ${buku.judul}") }
                            print("Masukkan Nomor Buku yang Ingin Dipinjam: ")
                            val index = readLine()!!.toInt() - 1
                            if (index in bukuList.indices) {
                                peminjam.pinjamBuku(bukuList[index], bukuList)
                            } else {
                                println("Nomor buku tidak valid.")
                            }
                        } else {
                            println("Peminjam dengan NIM '$nim' tidak ditemukan.")
                        }
                    } else {
                        println("Daftar peminjam atau buku kosong.")
                    }
                }
                4 -> {
                    if (peminjamList.isNotEmpty()) {
                        print("Masukkan NIM Peminjam: ")
                        val nim = readLine()!!
                        val peminjam = peminjamList.find { it.nim == nim }
                        if (peminjam != null) {
                            println("Daftar Buku Dipinjam:")
                            peminjam.bukuDipinjam.forEachIndexed { index, buku -> println("${index + 1}. ${buku.judul}") }
                            print("Masukkan Nomor Buku yang Ingin Dikembalikan: ")
                            val index = readLine()!!.toInt() - 1
                            if (index in peminjam.bukuDipinjam.indices) {
                                peminjam.kembalikanBuku(peminjam.bukuDipinjam[index], bukuList)
                            } else {
                                println("Nomor buku tidak valid.")
                            }
                        } else {
                            println("Peminjam dengan NIM '$nim' tidak ditemukan.")
                        }
                    } else {
                        println("Daftar peminjam kosong.")
                    }
                }
                5 -> {
                    if (peminjamList.isNotEmpty()) {
                        for (peminjam in peminjamList) {
                            peminjam.showData()
                            peminjam.showInfo()
                        }
                    } else {
                        println("Daftar peminjam kosong.")
                    }
                }
                6 -> {
                    logoutStaff()
                    loginStaff()
                }
                7 -> {
                    println("Terima kasih telah menggunakan Aplikasi Perpustakaan!")
                    return
                }
                else -> println("Pilihan tidak valid. Silakan coba lagi!")
            }
            print("Kembali ke Menu Utama [Y/N]? ")
            ulang = readLine()!!.toString()
        } while (ulang.equals("Y", ignoreCase = true))
    }
}
