<?php

namespace App\Enum;

enum StatusTiketEnum: string
{
    case MenungguPembayaran = 'Menunggu Pembayaran';
    case Dipesan = 'Dipesan';
    case Terkirim = 'Terkirim';
    case Digunakan = 'Digunakan';
    case Batal = 'Batal';
}
