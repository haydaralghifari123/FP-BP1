class Staff(val nama: String) {
    companion object {
        fun inputStaff(): Staff {
            print("Masukkan Nama Staff: ")
            val nama = readLine()!!.toString()
            return Staff(nama)
        }
    }
}