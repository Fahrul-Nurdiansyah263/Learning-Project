<?php

namespace App\Enum;

enum StatusPembayaranEnum: string
{
    case MenungguPembayaran = 'Menunggu Pembayaran';
    case Lunas = 'Lunas';
    case Gagal = 'Gagal';
    case Kadaluarsa = 'Kadaluarsa';
    case Refund = 'Refund';
}
