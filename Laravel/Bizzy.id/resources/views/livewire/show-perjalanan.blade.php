{{-- Be like water. --}}

<div>
    <div class="container mx-auto p-4">
        <h1 class="text-3xl font-bold mb-6 text-center">Jadwal Perjalanan Bus</h1>

        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            @forelse ($perjalananTersedia as $perjalanan)
                <div class="bg-white rounded-lg shadow-md overflow-hidden transition-transform transform hover:-translate-y-1">
                    <div class="p-6">
                        <div class="mb-4">
                            <p class="text-sm text-gray-500">Rute Perjalanan</p>
                            <h2 class="text-2xl font-bold text-gray-800">
                                {{ $perjalanan->rute->terminalKeberangkatan->kota }} → {{ $perjalanan->rute->terminalTujuan->kota }}
                            </h2>
                        </div>

                        <div class="mb-4">
                            <p class="text-sm text-gray-500">Bus</p>
                            <p class="text-lg font-semibold">{{ $perjalanan->bus->nama }} ({{ $perjalanan->bus->kelas }})</p>
                        </div>

                        <div class="flex justify-between items-center mb-4">
                            <div>
                                <p class="text-sm text-gray-500">Berangkat</p>
                                <p class="font-medium">{{ $perjalanan->waktu_berangkat->format('d M Y, H:i') }}</p>
                            </div>
                            <div>
                                <p class="text-sm text-gray-500">Tiba (Estimasi)</p>
                                <p class="font-medium">{{ $perjalanan->waktu_tiba->format('d M Y, H:i') }}</p>
                            </div>
                        </div>

                        <div class="mt-6 text-right">
                            <p class="text-sm text-gray-500">Harga per Tiket</p>
                            <p class="text-2xl font-bold text-indigo-600">Rp{{ number_format($perjalanan->harga, 0, ',', '.') }}</p>
                        </div>
                    </div>

                    <div class="bg-gray-50 p-4">
                        <button 
                            wire:click="startPayment({{ $perjalanan->id }})" 
                            wire:loading.attr="disabled"
                            class="w-full bg-indigo-600 text-white font-bold py-2 px-4 rounded-lg hover:bg-indigo-700 transition duration-300 disabled:opacity-50">
                            Pesan Tiket
                        </button>
                    </div>
                </div>
            @empty
                <p class="col-span-full text-center text-gray-500">Belum ada jadwal yang tersedia saat ini.</p>
            @endforelse
        </div>
    </div>

    @push('scripts')
    {{-- Script untuk Midtrans Snap --}}
    <script src="https://app.sandbox.midtrans.com/snap/snap.js" data-client-key="{{ env('MIDTRANS_CLIENT_KEY') }}"></script>
    <script>
        document.addEventListener('livewire:initialized', () => {
            @this.on('snap-pay', (event) => {
                snap.pay(event.token, {
                    onSuccess: function(result){
                        alert("Pembayaran sukses!");
                        console.log(result);
                        // Anda bisa redirect atau refresh halaman di sini
                        // window.location.reload(); 
                    },
                    // ... callback lainnya ...
                });
            });
        });
    </script>
    @endpush
</div>