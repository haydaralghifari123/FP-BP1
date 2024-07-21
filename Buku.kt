class Buku(
    val judul: String,
    val penulis: String,
    val thTerbit: Int,
    val genre: String,
    val isbn: String,
    val kode: String
) {
    fun showInfoBuku() {
        println("\n\n----- Informasi Buku -----")
        println("Judul : $judul")
        println("Penulis : $penulis")
        println("Tahun Terbit : $thTerbit")
        println("Genre : $genre")
        println("ISBN : $isbn")
        println("Kode Buku : $kode")
    }

    companion object {
        fun inputBuku(): Buku {
            print("Masukkan Judul Buku: ")
            val judul = readLine()!!.toString()
            print("Masukkan Penulis Buku: ")
            val penulis = readLine()!!.toString()
            print("Masukkan Tahun Terbit Buku: ")
            val thTerbit = readLine()!!.toInt()
            print("Masukkan Genre Buku: ")
            val genre = readLine()!!.toString()
            print("Masukkan ISBN Buku: ")
            val isbn = readLine()!!.toString()
            print("Masukkan Kode Buku: ")
            val kode = readLine()!!.toString()
            return Buku(judul, penulis, thTerbit, genre, isbn, kode)
        }
    }
}