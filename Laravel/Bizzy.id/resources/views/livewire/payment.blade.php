    {{-- Care about people's approval and you will be their prisoner. --}}
<div>
    <div class="card mx-auto" style="max-width: 500px;">
        <div class="card-header">
            <h5 class="card-title">Formulir Pembayaran</h5>
        </div>
        <div class="card-body">
            <form wire:submit="checkout">
                <div class="mb-3">
                    <label for="name" class="form-label">Nama Lengkap</label>
                    <input type="text" class="form-control" id="name" wire:model="name">
                    @error('name') <span class="text-danger">{{ $message }}</span> @enderror
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" wire:model="email">
                    @error('email') <span class="text-danger">{{ $message }}</span> @enderror
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">No. Telepon</label>
                    <input type="text" class="form-control" id="phone" wire:model="phone">
                    @error('phone') <span class="text-danger">{{ $message }}</span> @enderror
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Alamat</label>
                    <textarea class="form-control" id="address" wire:model="address"></textarea>
                    @error('address') <span class="text-danger">{{ $message }}</span> @enderror
                </div>
                
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">
                        <span wire:loading.remove wire:target="checkout">
                            Bayar Sekarang (Rp {{ number_format($totalAmount) }})
                        </span>
                        <span wire:loading wire:target="checkout">
                            Memproses...
                        </span>
                    </button>
                </div>
            </form>
        </div>
    </div>

    @push('scripts')
    <script type="text/javascript"
        src="https://app.sandbox.midtrans.com/snap/snap.js"
        data-client-key="{{ config('services.midtrans.client_key') }}"></script>
        
    <script>
        document.addEventListener('livewire:initialized', () => {
            @this.on('snap-show', (event) => {
                window.snap.pay(event.token, {
                    onSuccess: function(result){
                        // Redirect atau tampilkan pesan sukses
                        alert("Pembayaran berhasil!"); console.log(result);
                        window.location.href = "/"; // Ganti dengan halaman sukses Anda
                    },
                    onPending: function(result){
                        alert("Pembayaran tertunda!"); console.log(result);
                    },
                    onError: function(result){
                        alert("Pembayaran gagal!"); console.log(result);
                    },
                    onClose: function(){
                        alert('Anda menutup popup tanpa menyelesaikan pembayaran');
                    }
                });
            });
        });
    </script>
    @endpush
</div>