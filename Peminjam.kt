class Peminjam(
    var nim: String,
    var nama: String,
    var jurusan: String,
    var kelas: String,
    var thn: Int
) {
    val bukuDipinjam = mutableListOf<Buku>()

    fun showData() {
        println("\n\n----- DATA AKUN -----")
        println("NIM : $nim")
        println("Nama : $nama")
        println("Jurusan : $jurusan")
        println("Kelas : $kelas")
        println("Tahun Masuk : $thn")
    }

    fun pinjamBuku(buku: Buku, daftarBuku: MutableList<Buku>) {
        if (buku in daftarBuku) {
            bukuDipinjam.add(buku)
            daftarBuku.remove(buku)
            println("$nama meminjam buku '${buku.judul}'")
        } else {
            println("Buku '${buku.judul}' tidak tersedia.")
        }
    }

    fun kembalikanBuku(buku: Buku, daftarBuku: MutableList<Buku>) {
        if (buku in bukuDipinjam) {
            bukuDipinjam.remove(buku)
            daftarBuku.add(buku)
            println("$nama mengembalikan buku '${buku.judul}'")
        } else {
            println("$nama tidak meminjam buku '${buku.judul}'")
        }
    }

    fun showInfo() {
        println("\n\n----- Informasi Peminjam -----")
        println("Nama : $nama")
        println("NIM : $nim")
        println("Jurusan : $jurusan")
        println("Buku yang Dipinjam : ${bukuDipinjam.joinToString { it.judul }}")
    }

    companion object {
        fun inputPeminjam(): Peminjam {
            print("Masukkan NIM: ")
            val nim = readLine()!!.toString()
            print("Masukkan Nama: ")
            val nama = readLine()!!.toString()
            print("Masukkan Jurusan: ")
            val jurusan = readLine()!!.toString()
            print("Masukkan Kelas: ")
            val kelas = readLine()!!.toString()
            print("Masukkan Tahun Masuk: ")
            val thn = readLine()!!.toInt()
            return Peminjam(nim, nama, jurusan, kelas, thn)
        }
    }
}
