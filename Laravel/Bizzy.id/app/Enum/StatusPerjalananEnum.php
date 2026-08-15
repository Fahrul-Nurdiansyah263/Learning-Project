<?php

namespace App\Enum;

enum StatusPerjalananEnum: string
{
    case Tersedia = 'Tersedia';
    case Penuh = 'Penuh';
    case Berangkat = 'Berangkat';
    case Tiba = 'Tiba';
    case Batal = 'Batal';
}
