<template>
    <div class="dashboard">
        <div class="container-info">
            <div class="card-info">
                <div class="info-header">
                    <h2>Vendas</h2>
                    <i class="pi pi-chart-line" style="font-size: 2rem"></i>
                </div>
                <p>120</p>
                <p>Porcentagem de lucro %</p>

            </div>

            <div class="card-info">
                <div class="info-header">
                    <h2>Ganhos</h2>
                    <i class="pi pi-wallet" style="font-size: 2rem"></i>
                </div>
                <p>120</p>
                <p>Porcentagem de lucro %</p>

            </div>

            <div class="card-info">
                <div class="info-header">
                    <h2>Visitantes</h2>
                    <i class="pi pi-user" style="font-size: 2rem"></i>
                </div>
                <p>120</p>
                <p>Porcentagem de lucro %</p>

            </div>

            <div class="card-info">
                <div class="info-header">
                    <h2>Membros</h2>
                    <i class="pi pi-verified" style="font-size: 2rem"></i>
                </div>
                <p>120</p>
                <p>Porcentagem de lucro %</p>

            </div>
        </div>
        <div class="card">

            <div class="card flex justify-content-between">
                <p style="font-size: 2rem;" class="m-0">Gastos e despesas</p>
                <Dropdown v-model="selectedCity" :options="cities" optionLabel="name" placeholder="Selecione a data"
                    class="w-full md:w-14rem" />
            </div>
            <Chart type="bar" :data="chartData" :options="chartOptions" class="h-30rem" />
        </div>

        <div class="card">
            <p style="font-size: 2rem;">Dashboard 2 </p>
            <Chart type="line" :data="chartData" :options="chartOptions" class="h-30rem" />
        </div>
    </div>
</template>

<style scoped>
.dashboard {
    width: 100%;
    display: flex;
    gap: 30px;
    justify-content: center;
    justify-items: center;
    flex-wrap: wrap;
}

.card {
    width: 100%;
}

.card-info {
    width: auto;
    height: auto;
    background: var(--surface-card);
    padding: 2rem;
    border-radius: 10px;
    margin-bottom: 1rem;
}

.container-info {
    display: grid;
    grid-template-columns: auto auto auto auto;
    gap: 30px;
    width: 100%;
}

.info-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}
</style>

<script setup>
import { ref, onMounted } from "vue";

onMounted(() => {
    chartData.value = setChartData();
    chartOptions.value = setChartOptions();
});

const chartData = ref();
const chartOptions = ref();
const selectedCity = ref();
const cities = ref([
    { name: 'Última semana' },
    { name: 'Essa semana' },
    { name: 'Este mês' }
]);

const setChartData = () => {
    const documentStyle = getComputedStyle(document.documentElement);

    return {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [
            {
                label: 'My First dataset',
                backgroundColor: documentStyle.getPropertyValue('--cyan-500'),
                borderColor: documentStyle.getPropertyValue('--cyan-500'),
                data: [65, 59, 80, 81, 56, 55, 40]
            },
            {
                label: 'My Second dataset',
                backgroundColor: documentStyle.getPropertyValue('--gray-500'),
                borderColor: documentStyle.getPropertyValue('--gray-500'),
                data: [28, 48, 40, 19, 86, 27, 90]
            }
        ]
    };
};
const setChartOptions = () => {
    const documentStyle = getComputedStyle(document.documentElement);
    const textColor = documentStyle.getPropertyValue('--text-color');
    const textColorSecondary = documentStyle.getPropertyValue('--text-color-secondary');
    const surfaceBorder = documentStyle.getPropertyValue('--surface-border');

    return {
        maintainAspectRatio: false,
        aspectRatio: 0.8,
        plugins: {
            legend: {
                labels: {
                    color: textColor
                }
            }
        },
        scales: {
            x: {
                ticks: {
                    color: textColorSecondary,
                    font: {
                        weight: 500
                    }
                },
                grid: {
                    display: false,
                    drawBorder: false
                }
            },
            y: {
                ticks: {
                    color: textColorSecondary
                },
                grid: {
                    color: surfaceBorder,
                    drawBorder: false
                }
            }
        }
    };
}
</script>
