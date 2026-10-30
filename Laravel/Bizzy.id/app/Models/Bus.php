<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class Bus extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'bus';
    public $timestamps = false;
    protected $fillable = ['nama','nomor_polisi', 'kapasitas', 'kelas'];
}
