package com.example.demo.Service.Implement;

import com.example.demo.DTO.Endereco.EnderecoDTO;
import com.example.demo.DTO.Pagamento.PagamentoDTO;
import com.example.demo.DTO.Pagamento.PagamentoUpdateDTO;
import com.example.demo.DTO.Pedido.PedidoDTO;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.*;
import com.example.demo.Repository.*;
import com.example.demo.Service.PagamentoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagamentoServiceImpl implements PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository, PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PagamentoDTO findById(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pagamento não encontrado"));

        return new PagamentoDTO(pagamento);
    }

    @Override
    public List<PagamentoDTO> findAll() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        List<PagamentoDTO> pagamentoDTOS = new ArrayList<>();

        for (Pagamento pagamento : pagamentos) {
            pagamentoDTOS.add(new PagamentoDTO(pagamento));
        }

        return pagamentoDTOS;
    }

    @Override
    public PagamentoDTO save(PedidoDTO dto) {
        Pedido pedido = pedidoRepository.findById(dto.id())
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
        Pagamento pagamento = new Pagamento(pedido);
        PagamentoDTO pagamentoSalvo = new PagamentoDTO(pagamentoRepository.save(pagamento));
        return pagamentoSalvo;
    }

    @Override
    public PagamentoDTO update(Long id, PagamentoUpdateDTO novo) {
        Pagamento existente = pagamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pagamento não encontrado"));

        if (novo.status() != null) {
            existente.setStatus(novo.status());
        }

        if (novo.dataPagamento() != null) {
            existente.setDataPagamento(novo.dataPagamento());
        }

        return new PagamentoDTO(pagamentoRepository.save(existente));
    }

    @Override
    public void delete(Long id) {
        pagamentoRepository.deleteById(id);
    }

    @Override
    public PagamentoDTO buscarPorPedido(Long idPedido) {
        Pagamento pagamento = pagamentoRepository.findByPedidoIdPedido(idPedido).orElseThrow(() -> new ResourceNotFoundException("Pagamento não encontrado"));
        return new PagamentoDTO(pagamento);
    }
}
