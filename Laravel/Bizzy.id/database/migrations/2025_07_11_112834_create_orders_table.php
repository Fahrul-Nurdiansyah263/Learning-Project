// database/migrations/xxxx_xx_xx_xxxxxx_create_orders_table.php
use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up(): void
    {
        Schema::create('orders', function (Blueprint $table) {
            $table->id();
            $table->string('order_id')->unique(); // ID unik untuk Midtrans
            $table->string('name');
            $table->string('email');
            $table->string('phone');
            $table->text('address');
            $table->bigInteger('total_amount');
            $table->string('status')->default('pending'); // Kolom status pesanan
            $table->string('snap_token')->nullable(); // Untuk menyimpan token dari Midtrans
            $table->timestamps();
        });
    }

    public function down(): void
    {
        Schema::dropIfExists('orders');
    }
};