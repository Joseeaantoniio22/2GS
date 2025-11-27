import { Router } from 'express';
import { prisma } from '../prisma';
import { authMiddleware } from '../middleware/auth';
const router = Router();
// Listar productos
router.get('/', authMiddleware, async (req, res) => {
const products = await prisma.product.findMany();
res.json(products);
});
// Crear producto
router.post('/', authMiddleware, async (req, res) => {
const { name, price } = req.body;
const product = await prisma.product.create({ data: { name, price } });
res.json(product);
});
// Actualizar producto
router.put('/:id', authMiddleware, async (req, res) => {
const { id } = req.params;
const { name, price } = req.body;
const product = await prisma.product.update({ where: { id: Number(id) }, data: { name, price } });
res.json(product);
});
// Eliminar producto
router.delete('/:id', authMiddleware, async (req, res) => {
const { id } = req.params;
await prisma.product.delete({ where: { id: Number(id) } });
res.json({ message: 'Deleted' });
});
export default router;