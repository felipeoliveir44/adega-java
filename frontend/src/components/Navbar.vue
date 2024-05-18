<template>
    <div class="card">
        <Sidebar v-model:visible="visible">
            <template #container="{ closeCallback }">
                <div class="flex flex-column h-full">
                    <div class="flex align-items-center justify-content-between px-4 pt-3 flex-shrink-0">
                        <span class="inline-flex align-items-center gap-2">
                            <img src="../assets/img/logotipo.jpg" alt="Logotipo da casa do vinho" width="40">
                            <span class="font-semibold text-2xl text-primary">Casa do vinho</span>
                        </span>
                        <span>
                            <Button type="button" @click="closeCallback" icon="pi pi-times" rounded outlined
                                class="h-2rem w-2rem"></Button>
                        </span>
                    </div>
                    <div class="overflow-y-auto">
                        <ul class="list-none p-3 m-0">
                            <li>
                                <ul class="list-none p-0 m-0 overflow-hidden">

                                    <router-link to="/" class="router" @click.native="closeSidebar">
                                        <li
                                            class="flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors p-ripple">
                                            <i class="pi pi-user mr-2 "></i>
                                            <span class="font-medium">Home</span>
                                        </li>
                                    </router-link>

                                    <router-link to="/funcionario" class="router" @click.native="closeSidebar">
                                        <li
                                            class="flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors p-ripple">
                                            <i class="pi pi-bookmark mr-2"></i>
                                            <span class="font-medium">Funcionarios</span>
                                        </li>
                                    </router-link>

                                    <router-link to="/estoque" class="router" @click.native="closeSidebar">
                                        <li
                                            class="flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors p-ripple">

                                            <i class="pi pi-chart-line mr-2"></i>
                                            <span class="font-medium">Estoque</span>
                                        </li>
                                    </router-link>

                                    <router-link to="/pdv" class="router" @click.native="closeSidebar">
                                        <li
                                            class="flex align-items-center cursor-pointer p-3 border-round text-700 hover:surface-100 transition-duration-150 transition-colors p-ripple">
                                            <i class="pi pi-users mr-2"></i>
                                            <span class="font-medium">PDV</span>
                                        </li>
                                    </router-link>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <hr class="mb-3 mx-3 border-top-1 border-none surface-border" />
                    <div class="mt-auto flex flex-row align-items-center" >
                        <div
                            class="m-3 flex align-items-center p-3 gap-2 border-round text-700 hover:surface-100 transition-duration-150 transition-colors p-ripple">
                            <Avatar image="https://primefaces.org/cdn/primevue/images/avatar/amyelsner.png"
                                shape="circle" />
                            <span class="font-bold">Amy Elsner</span>

                        </div>
                        <Button label="Sair" class="p-button-sm" />
                    </div>
                </div>
            </template>
        </Sidebar>
        <Button icon="pi pi-bars" @click="visible = true" />
    </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from 'vue-router';

const router = useRouter();
const visible = ref(false);

const closeSidebar = () => {
    visible.value = false;
};

router.afterEach(() => {
    closeSidebar();
});

</script>
